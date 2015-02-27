package utils;

import java.util.HashMap;
import java.util.Map;

public class Languages {
	
	public static final String ENGLISH_LANGUAGE = "EN";
	public static final String RUSSIAN_LANGUAGE = "RUS";	
	
	public final static Languages language = new Languages();
	
	private static Map<String, String> enLanguage;
	private static Map<String, String> rusLanguage;
	
	private Languages(){
		enLanguage = new HashMap<String, String>();
		rusLanguage = new HashMap<String, String>();
		//footer for each page String
		enLanguage.put("footerTwitter", "Twitter Feed");
		rusLanguage.put("footerTwitter", "Твиттер");
		enLanguage.put("footerSitemap", "Sitemap");
		rusLanguage.put("footerSitemap", "Карта сайта");
		enLanguage.put("footerAbout", "About");
		rusLanguage.put("footerAbout", "О Нас");
		enLanguage.put("footerServices", "Services");
		rusLanguage.put("footerServices", "Сервис");
		enLanguage.put("footerSupport", "Support");
		rusLanguage.put("footerSupport", "Поддержка");
		enLanguage.put("footerContact", "Contact");
		rusLanguage.put("footerContact", "Контакт нас");
		enLanguage.put("footerSocialNetworks", "Social networks");
		rusLanguage.put("footerSocialNetworks", "Обратная связь");
		//splash screen Strings
		enLanguage.put("splashScreenTitle", "Hello");
		rusLanguage.put("splashScreenTitle", "Привет");
		enLanguage.put("splashScreenInfo", "This is non-profit project to make our road safer");
		rusLanguage.put("splashScreenInfo", "Это некомрческий проекут цель которого сделать дороги безопаснее");
		enLanguage.put("splashScreenClose", "Close");
		rusLanguage.put("splashScreenClose", "Закрыть");
		//index page body String
		enLanguage.put("indexWelcome", "Welcome");
		rusLanguage.put("indexWelcome", "Добро пожаловать");
		enLanguage.put("indexComplaint", "Complaint");
		rusLanguage.put("indexComplaint", "Жалоба");
		enLanguage.put("indexEmail", "email");
		rusLanguage.put("indexEmail", "имаил");
		enLanguage.put("indexOr", "OR");
		rusLanguage.put("indexOr", "ИЛИ");
		enLanguage.put("indexPhone", "Phone");
		rusLanguage.put("indexPhone", "Телефон");
		enLanguage.put("indexAnonymous", "Anonymous");
		rusLanguage.put("indexAnonymous", "Анонимный");
		enLanguage.put("indexCreateComplaint", "Create Complaint");
		rusLanguage.put("indexCreateComplaint", "оставить жалобу");
		enLanguage.put("indexCreateAnonymousComplaint", "Create Anonymous Complaint");
		rusLanguage.put("indexCreateAnonymousComplaint", "Оставить анонимную жалобу");
		enLanguage.put("indexEnter", "Enter");
		rusLanguage.put("indexEnter", "Вход");
		enLanguage.put("indexPassword", "Password");
		rusLanguage.put("indexPassword", "Пароль");
		enLanguage.put("indexBadge", "Badge");
		rusLanguage.put("indexBadge", "Значек");
		enLanguage.put("indexSignIn", "Sign In");
		rusLanguage.put("indexSignIn", "Вийти");
		enLanguage.put("indexSignUp", "Sign Up");
		rusLanguage.put("indexSignUp", "Регистрация");
	}
	

	
	public String getWord(String language, String index)
	{
		if(language.compareTo(ENGLISH_LANGUAGE)==0)
		{
			return enLanguage.get(index);
		} 
		if(language.compareTo(RUSSIAN_LANGUAGE)==0)
		{
			return rusLanguage.get(index);
		}
		return "unknown";
	}
}
