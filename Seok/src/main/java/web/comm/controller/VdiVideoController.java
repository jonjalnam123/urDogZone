package web.comm.controller;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableAspectJAutoProxy
@RestController
public class VdiVideoController {

	private static final Logger logger = LoggerFactory.getLogger(VdiVideoController.class);

	 /**
	* @methodName : videoStream
	* @author        	 : CJS
	* @date            	 : 2025.10.23
	* @description		 : 실시간 영상 재생 
	* ===================================
	* DATE              AUTHOR             NOTE
	* ===================================
	* 2025.10.23        CJS       최초 생성
	*/
    @RequestMapping( value = "/video/videoStream")
    public ResponseEntity<ResourceRegion> videoStream(@RequestParam("path") String path, @RequestHeader HttpHeaders headers) throws Exception {
    	logger.debug("=========== [ VdiVideoController ] : videoStream===========");
    	logger.debug("비디오 경로 : {}" + path);
    	Path filePath = Paths.get(path); 
        UrlResource video = new UrlResource(filePath.toUri());
        if (!video.exists()) {
        	logger.debug("해당하는 경로에 비디오가 없습니다.");
        	return ResponseEntity.notFound().build();
        }

        MediaType mediaType = MediaTypeFactory.getMediaType(video).orElse(MediaType.valueOf("video/mp4"));

        ResourceRegion region = resourceRegion(video, headers);

        HttpHeaders out = new HttpHeaders();
        out.set(HttpHeaders.ACCEPT_RANGES, "bytes");

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT) // 206
                .headers(out)
                .contentType(mediaType)
                .body(region);
    }

	 /**
	* @methodName : resourceRegion
	* @author        	 : CJS
	* @date            	 : 2025.10.23
	* @description		 : 영상 바이트 구간 정리
	* ===================================
	* DATE              AUTHOR             NOTE
	* ===================================
	* 2025.10.23        CJS       최초 생성
	*/
    private ResourceRegion resourceRegion(UrlResource video, HttpHeaders headers) throws Exception {
    	logger.debug("=========== [ VdiVideoController ] : resourceRegion===========");
        long contentLength = video.contentLength();
        long chunkSize = 1024 * 1024; // 1MB 청크

        if (headers.getRange().isEmpty()) {
            long len = Math.min(chunkSize, contentLength);
            return new ResourceRegion(video, 0, len);
        } else {
            HttpRange range = headers.getRange().get(0);
            long start = range.getRangeStart(contentLength);
            long end   = range.getRangeEnd(contentLength);
            long rangeLen = Math.min(chunkSize, end - start + 1);
            return new ResourceRegion(video, start, rangeLen);
        }
    }
    
	 /**
	* @methodName : videoDown
	* @author        	 : CJS
	* @date            	 : 2025.10.23
	* @description		 : 영상 다운로드 
	* ===================================
	* DATE              AUTHOR             NOTE
	* ===================================
	* 2025.10.23        CJS       최초 생성
	*/
    @RequestMapping( value="/video/videoDown")
    public ResponseEntity<?> videoDown( @RequestParam("path") String path, @RequestParam("fileName") String fileName, @RequestHeader HttpHeaders headers ) throws Exception {
    	logger.debug("=========== [ VdiVideoController ] : videoDown===========");
    	
    	logger.debug("비디오 경로 : {}", path);
    	logger.debug("비디오 이름 : {}", fileName);

        // 테스트: 절대경로
        Path filePath = Paths.get(path);
        String originalName = fileName;

        UrlResource resource = new UrlResource(filePath.toUri());
        if (!resource.exists() || !resource.isReadable()) {
        	logger.debug("해당하는 경로에 비디오가 없습니다.");
            return ResponseEntity.notFound().build();
        }

        long contentLength = resource.contentLength();
        MediaType mediaType = MediaTypeFactory.getMediaType(resource)
                .orElse(MediaType.APPLICATION_OCTET_STREAM);

        HttpHeaders out = new HttpHeaders();
        out.set(HttpHeaders.ACCEPT_RANGES, "bytes");
        out.setContentType(mediaType);
        out.setContentDisposition(
            ContentDisposition.builder("attachment").filename(originalName, StandardCharsets.UTF_8).build()
        );

        // Range 헤더 없으면 200 통파일 다운로드
        if (headers.getRange().isEmpty()) {
            out.setContentLength(contentLength);
            return new ResponseEntity<>(resource, out, HttpStatus.OK);
        }

        // Range 헤더 있으면 206 재개/구간 다운로드
        HttpRange range = headers.getRange().get(0);
        long start = range.getRangeStart(contentLength);
        long end   = range.getRangeEnd(contentLength);
        long rangeLen = end - start + 1;

        out.set(HttpHeaders.CONTENT_RANGE, "bytes " + start + "-" + end + "/" + contentLength);
        out.setContentLength(rangeLen);

        ResourceRegion region = new ResourceRegion(resource, start, rangeLen);
        return new ResponseEntity<>(region, out, HttpStatus.PARTIAL_CONTENT);
    }
}
