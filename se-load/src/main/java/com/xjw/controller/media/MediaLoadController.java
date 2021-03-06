package com.xjw.controller.media;

import static java.nio.file.StandardOpenOption.READ;

import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xjw.controller.BaseController;
import com.xjw.utility.DESEncrypt;
import com.xjw.utility.MD5Util;

@Controller
@RequestMapping("/media/load/")
public class MediaLoadController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(MediaLoadController.class);

	private static final int BUFFER_LENGTH = 1024 * 16; // 一次读取的字节长度
	private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24 * 100;
	private static final Pattern RANGE_PATTERN = Pattern.compile("bytes=(?<start>\\d*)-(?<end>\\d*)");
	@Value("${upload.video.directory}")
	private String videoDirectory;

	/**
	 * 跳转到播放页面
	 * @param code  素材编号
	 */
	@RequestMapping(value = "/{path}/{key}/", method = RequestMethod.GET)
	public void loading(@PathVariable String path, @PathVariable String key, HttpServletRequest request, HttpServletResponse response) throws Exception {
		path = new DESEncrypt("DFDJ#832k").decrypt(URLDecoder.decode(path, "utf-8"));
		logger.debug("path:" + path);
		if(key.equals(MD5Util.md5Encode(path + "dj83*3jntHsnS32KS234sdf5"))){
			Path videoFile = Paths.get(videoDirectory, path);
			int length = (int) Files.size(videoFile);
			int start = 0;
			int end = length - 1;

			String range = request.getHeader("Range");
			range = range == null ? "" : range;
			Matcher matcher = RANGE_PATTERN.matcher(range);

			if (matcher.matches()) {
				String startGroup = matcher.group("start");
				start = startGroup.isEmpty() ? start : Integer.valueOf(startGroup);
				start = start < 0 ? 0 : start;

				String endGroup = matcher.group("end");
				end = endGroup.isEmpty() ? end : Integer.valueOf(endGroup);
				end = end > length - 1 ? length - 1 : end;
			}

			int contentLength = end - start + 1;
			response.reset();
			response.setContentType("application/octet-stream");
			response.setBufferSize(BUFFER_LENGTH);
			 response.setHeader("Content-Disposition",
			 String.format("inline;filename=\"%s\"", "test3.mp4"));
			response.setHeader("Accept-Ranges", "bytes");
			response.setDateHeader("Last-Modified", Files.getLastModifiedTime(videoFile).toMillis());
			response.setDateHeader("Expires", System.currentTimeMillis() + EXPIRE_TIME);
			response.setContentType(Files.probeContentType(videoFile));
			response.setHeader("Content-Range", String.format("bytes %s-%s/%s", start, end, length));
			response.setHeader("Content-Length", String.format("%s", contentLength));
			response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
	
			int bytesRead;
			int bytesLeft = contentLength;
			ByteBuffer buffer = ByteBuffer.allocate(BUFFER_LENGTH);
	
			try (SeekableByteChannel input = Files.newByteChannel(videoFile, READ); OutputStream output = response.getOutputStream()) {
				input.position(start);
				while ((bytesRead = input.read(buffer)) != -1 && bytesLeft > 0) {
					buffer.clear();
					output.write(buffer.array(), 0, bytesLeft < bytesRead ? bytesLeft : bytesRead);
					bytesLeft -= bytesRead;
				}
				input.close();
				output.close();
			}
		}
	}
	
}
