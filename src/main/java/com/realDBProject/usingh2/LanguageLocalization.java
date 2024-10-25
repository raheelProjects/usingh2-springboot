package com.realDBProject.usingh2;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageLocalization {
	
	private MessageSource msgs;
	private String introductionKey="introduction.message";
	private String descriptionKey="description.message";

	public LanguageLocalization(MessageSource msgs) {
		super();
		this.msgs = msgs;
	}
	
	
	@GetMapping(path="/introduction")
	public String getIntroduction() {
		Locale locale = LocaleContextHolder.getLocale();
		
		return msgs.getMessage(introductionKey, null, "Default Message", locale);
	}
	
	@GetMapping(path="/description")
	public String getDescription() {
		Locale locale = LocaleContextHolder.getLocale();
		
		return msgs.getMessage(descriptionKey, null, "Default Message", locale);
	}

}
