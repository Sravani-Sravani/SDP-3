package com.klu.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@ControllerAdvice
public class MaxSizeErrorHandler 
{
	private static final Logger logger = LoggerFactory.getLogger("MaxSizeErrorHandler.class");

    @ExceptionHandler
    public String maxSizeError(MultipartException e, RedirectAttributes redirectAttributes) {
        logger.info("Max File Size Exception Occurs");
        redirectAttributes.addFlashAttribute("message", "Excced Max File Size Error");
        return "redirect:/";
    }
}
