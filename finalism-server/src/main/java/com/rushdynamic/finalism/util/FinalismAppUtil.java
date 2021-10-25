package com.rushdynamic.finalism.util;

import java.util.Arrays;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalismAppUtil {
	
	static Logger logger = LoggerFactory.getLogger(FinalismAppUtil.class);
	
	public static String rightPadString(String inputStr, Integer paddingLen) {
		return (inputStr.length() < paddingLen ? rightPadString(inputStr + "0", paddingLen) : inputStr);
	}
	
	public static String encodeBase64(String inputStr) {
		return Base64.getEncoder().encodeToString(inputStr.getBytes());
	}
	
	public static String cleanUrl(String originalUrl) {
		// TODO: Remove http/https, www, and // before encoding
		if(originalUrl.endsWith("/")) {
			originalUrl = originalUrl.substring(0, originalUrl.length() - 1);
		}
		String[] emptyArr = new String[FinalismAppConstants.filteredWords.length];
		Arrays.fill(emptyArr, "");
		originalUrl = StringUtils.replaceEach(originalUrl, FinalismAppConstants.filteredWords, emptyArr);
		logger.info("Cleaned URL:" + originalUrl);
		String encodedUrl = encodeBase64(originalUrl);
		String cleanUrl = encodedUrl.replaceAll("[^a-zA-Z0-9]", "");
		return rightPadString(cleanUrl, 7);
	}
}
