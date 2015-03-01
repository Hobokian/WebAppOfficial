package utils;

import java.util.HashMap;
import java.util.Map;

public class Languages {
	
	public static final String ENGLISH_LANGUAGE = "EN";
	public static final String FRENCH_LANGUAGE  = "FR";
	public static final String RUSSIAN_LANGUAGE = "RUS";	
	
	public final static Languages language = new Languages();
	
	private static Map<String, String> enLanguage;
	private static Map<String, String> rusLanguage;
	private static Map<String, String> frLanguage;
	
	private Languages(){
		 enLanguage = new HashMap<String, String>();
		rusLanguage = new HashMap<String, String>();
		 frLanguage = new HashMap<String, String>();
		//footer page Strings
		 enLanguage.put("footerTwitter", "Twitter Feed");
		 frLanguage.put("footerTwitter", "");
		rusLanguage.put("footerTwitter", "Твиттер");
		 enLanguage.put("footerSitemap", "Sitemap");
		 frLanguage.put("footerSitemap", "");
		rusLanguage.put("footerSitemap", "Карта сайта");
		 frLanguage.put("footerAbout", "");
		 enLanguage.put("footerAbout", "About");
		rusLanguage.put("footerAbout", "О Нас");
		 enLanguage.put("footerServices", "Services");
		 frLanguage.put("footerServices", "");
		rusLanguage.put("footerServices", "Сервис");
		 enLanguage.put("footerSupport", "Support");
		 frLanguage.put("footerSupport", "");
		rusLanguage.put("footerSupport", "Поддержка");
		 enLanguage.put("footerContact", "Contact");
		 frLanguage.put("footerContact", "");
		rusLanguage.put("footerContact", "Контакт нас");
		 enLanguage.put("footerSocialNetworks", "Social networks");
		 frLanguage.put("footerSocialNetworks", "");
		rusLanguage.put("footerSocialNetworks", "Обратная связь");
		//header page Strings
		 enLanguage.put("headerHi", "Hi");
		 frLanguage.put("headerHi", "");
		rusLanguage.put("headerHi", "Хай");
		 enLanguage.put("headerEditUser", "Edit profile");
		 frLanguage.put("headerEditUser", "");
		rusLanguage.put("headerEditUser", "Редактировать профиль");
		 enLanguage.put("headerLogout", "Log Out");
		 frLanguage.put("headerLogout", "");
		rusLanguage.put("headerLogout", "Выход");
		//menu page Strings
		 enLanguage.put("menuPoliceNews", "police news");
		 frLanguage.put("menuPoliceNews", "");
		rusLanguage.put("menuPoliceNews", "Новости");
		 enLanguage.put("menuHome", "Home");
		 frLanguage.put("menuHome", "");
		rusLanguage.put("menuHome", "домашняя станица");
		 enLanguage.put("menuMyCases", "My Cases");
		 frLanguage.put("menuMyCases", "");
		rusLanguage.put("menuMyCases", "Мои дела");
		 enLanguage.put("menuMyCityCases", "My City's Cases");
		 frLanguage.put("menuMyCityCases", "");
		rusLanguage.put("menuMyCityCases", "Городские Дела");
		 enLanguage.put("menuMyProvinceCases", "My Province's Cases");
		 frLanguage.put("menuMyProvinceCases", "");
		rusLanguage.put("menuMyProvinceCases", "Провинциальные дела");
		 enLanguage.put("menuHistory", "History");
		 frLanguage.put("menuHistory", "");
		rusLanguage.put("menuHistory", "История");
		 enLanguage.put("menuAdvancedSearch", "Advanced Search");
		 frLanguage.put("menuAdvancedSearch", "");
		rusLanguage.put("menuAdvancedSearch", "Поиск");
		
		
		//splash screen Strings
		 enLanguage.put("splashScreenTitle", "Hello");
		 frLanguage.put("splashScreenTitle", "");
		rusLanguage.put("splashScreenTitle", "Привет");
		 enLanguage.put("splashScreenInfo", "This is non-profit project to make our road safer");
		 frLanguage.put("splashScreenInfo", "");
		rusLanguage.put("splashScreenInfo", "Это некомрческий проекут цель которого сделать дороги безопаснее");
		 enLanguage.put("splashScreenClose", "Close");
		 frLanguage.put("splashScreenClose", "");
		rusLanguage.put("splashScreenClose", "Закрыть");
		//index page body Strings
		 enLanguage.put("indexWelcome", "Welcome");
		 frLanguage.put("indexWelcome", "");
		rusLanguage.put("indexWelcome", "Добро пожаловать");
		 enLanguage.put("indexComplaint", "Complaint");
		 frLanguage.put("indexComplaint", "");
		rusLanguage.put("indexComplaint", "Жалоба");
		 enLanguage.put("indexEmail", "email");
		 frLanguage.put("indexEmail", "");
		rusLanguage.put("indexEmail", "имаил");
		 enLanguage.put("indexOr", "OR");
		 frLanguage.put("indexOr", "");
		rusLanguage.put("indexOr", "ИЛИ");
		 enLanguage.put("indexPhone", "Phone");
		 frLanguage.put("indexPhone", "");
		rusLanguage.put("indexPhone", "Телефон");
		 enLanguage.put("indexAnonymous", "Anonymous");
		 frLanguage.put("indexAnonymous", "");
		rusLanguage.put("indexAnonymous", "Анонимный");
		 enLanguage.put("indexCreateComplaint", "Create Complaint");
		 frLanguage.put("indexCreateComplaint", "");
		rusLanguage.put("indexCreateComplaint", "оставить жалобу");
		 enLanguage.put("indexCreateAnonymousComplaint", "Create Anonymous Complaint");
		 frLanguage.put("indexCreateAnonymousComplaint", "");
		rusLanguage.put("indexCreateAnonymousComplaint", "Оставить анонимную жалобу");
		 enLanguage.put("indexEnter", "Enter");
		 frLanguage.put("indexEnter", "");
		rusLanguage.put("indexEnter", "Вход");
		 enLanguage.put("indexPassword", "Password");
		 frLanguage.put("indexPassword", "");
		rusLanguage.put("indexPassword", "Пароль");
		 enLanguage.put("indexBadge", "Badge");
		 frLanguage.put("indexBadge", "");
		rusLanguage.put("indexBadge", "Значек");
		 enLanguage.put("indexSignIn", "Sign In");
		 frLanguage.put("indexSignIn", "");
		rusLanguage.put("indexSignIn", "Вийти");
		 enLanguage.put("indexSignUp", "Sign Up");
		 frLanguage.put("indexSignUp", "");
		rusLanguage.put("indexSignUp", "Регистрация");
		//thanks page Strings
		 enLanguage.put("thanksTitle", "Submission Complete");
		 frLanguage.put("thanksTitle", "");
		rusLanguage.put("thanksTitle", "Отчет отправлен");
		 frLanguage.put("thanksHeader", "");
		 enLanguage.put("thanksHeader", "Thank you for your report");
		rusLanguage.put("thanksHeader", "Спасибо за ваш отчет");
		 enLanguage.put("thanksMessage", "We will review your report as soon as possible<br>Your report number is ");
		 frLanguage.put("thanksMessage", "");
		rusLanguage.put("thanksMessage", "Мы просмотрим ваш отчет в бижайнее время.<br>Ваш отчет имеет номер ");
		 enLanguage.put("thanksPostMessage", "If you have any questions about your complaint please contact with website support");
		 frLanguage.put("thanksPostMessage", "");
		rusLanguage.put("thanksPostMessage", "Если у нас какие нибуть вопросы о вашем очете пожалуйста свяжитесь с тех.поддержкой");
		//signUp page Strings
		rusLanguage.put("signUpTitle", "форма регистрации");
		 frLanguage.put("signUpTitle", "");
		 enLanguage.put("signUpTitle", "registration form");
		rusLanguage.put("signUpBadgeNumber", "Значек");
		 frLanguage.put("signUpBadgeNumber", "");
		 enLanguage.put("signUpBadgeNumber", "Badge Number");
		rusLanguage.put("signUpAccessCode", "Коде Доступа");
		 frLanguage.put("signUpAccessCode", "");
		 enLanguage.put("signUpAccessCode", "Access Code");
		rusLanguage.put("signUpName", "ФИО");
		 frLanguage.put("signUpName", "");
		 enLanguage.put("signUpName", "First and Last Name");
		rusLanguage.put("signUpEmail", "Имаил адрес");
		 frLanguage.put("signUpEmail", "");
		 enLanguage.put("signUpEmail", "Email Address");
		rusLanguage.put("signUpPhone", "Телефонный номер");
		 frLanguage.put("signUpPhone", "");
		 enLanguage.put("signUpPhone", "Phone Number");
		rusLanguage.put("signUpPassword", "Пароль");
		 frLanguage.put("signUpPassword", "");
		 enLanguage.put("signUpPassword", "Password");
		rusLanguage.put("signUpConfirmPassword", "Подтверждение Пароля");
		 frLanguage.put("signUpConfirmPassword", "");
		 enLanguage.put("signUpConfirmPassword", "Confirm Password");
		rusLanguage.put("signUpButton", "Регистрация");
		 frLanguage.put("signUpButton", "");
		 enLanguage.put("signUpButton", "SignUp");
		
		//report page String
		 enLanguage.put("reportTitle", "Complaint Form");
		 frLanguage.put("reportTitle", "");
		rusLanguage.put("reportTitle", "отчетная Форма");
		 enLanguage.put("reportPlateNumber", "Plate Number");
		 frLanguage.put("reportPlateNumber", "");
		rusLanguage.put("reportPlateNumber", "Номер");
		 enLanguage.put("reportURLlink", "URL Link");
		 frLanguage.put("reportURLlink", "");
		rusLanguage.put("reportURLlink", "URL ссылка");
		 enLanguage.put("reportStreet", "Street");
		 frLanguage.put("reportStreet", "");
		rusLanguage.put("reportStreet", "Улица");
		 enLanguage.put("reportPostalCode", "Postal Code");
		 frLanguage.put("reportPostalCode", "");
		rusLanguage.put("reportPostalCode", "Почтовй индекс");
		 enLanguage.put("reportDescription", "Description");
		 frLanguage.put("reportDescription", "");
		rusLanguage.put("reportDescription", "Пояснения");
		 enLanguage.put("reportButton", "Report");
		 frLanguage.put("reportButton", "");
		rusLanguage.put("reportButton", "Отправить Отчет");
		
		//common Strings
		rusLanguage.put("addCity", "Добавить Город");
		 frLanguage.put("addCity", "");
		 enLanguage.put("addCity", "Add City");
		rusLanguage.put("province", "Провинция");
		 frLanguage.put("province", "");
		 enLanguage.put("province", "Province");
		rusLanguage.put("city", "Город");
		 frLanguage.put("city", "");
		 enLanguage.put("city", "City");
		rusLanguage.put("backButton", "Назад");
		 frLanguage.put("backButton", "");
		 enLanguage.put("backButton", "Back");
		rusLanguage.put("lisenceAgreement", "Я прочитал и согласен с согланием.");
		 frLanguage.put("lisenceAgreement", "");
		 enLanguage.put("lisenceAgreement", "I read and accept the term in license agreement.");
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
		if(language.compareTo(FRENCH_LANGUAGE)==0)
		{
			return frLanguage.get(index);
		}
		return "unknown";
	}
}
