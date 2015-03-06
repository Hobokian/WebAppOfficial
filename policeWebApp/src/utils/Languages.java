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
		 frLanguage.put("footerTwitter", "Feed Twitter");
		rusLanguage.put("footerTwitter", "Твиттер");
		 enLanguage.put("footerSitemap", "Sitemap");
		 frLanguage.put("footerSitemap", "Plan du site");
		rusLanguage.put("footerSitemap", "Карта сайта");
		 frLanguage.put("footerAbout", "Sur Nous");
		 enLanguage.put("footerAbout", "About");
		rusLanguage.put("footerAbout", "О Нас");
		 enLanguage.put("footerServices", "Services");
		 frLanguage.put("footerServices", "Services");
		rusLanguage.put("footerServices", "Сервис");
		 enLanguage.put("footerSupport", "Support");
		 frLanguage.put("footerSupport", "Aide");
		rusLanguage.put("footerSupport", "Поддержка");
		 enLanguage.put("footerContact", "Contact");
		 frLanguage.put("footerContact", "Contact");
		rusLanguage.put("footerContact", "Контакт нас");
		 enLanguage.put("footerSocialNetworks", "Social networks");
		 frLanguage.put("footerSocialNetworks", "Les Réseaux Sociaux");
		rusLanguage.put("footerSocialNetworks", "Обратная связь");
		
		//header page Strings
		 enLanguage.put("headerHi", "Hi");
		 frLanguage.put("headerHi", "Bonjour");
		rusLanguage.put("headerHi", "Хай");
		 enLanguage.put("headerEditUser", "Edit profile");
		 frLanguage.put("headerEditUser", "Editer le profil");
		rusLanguage.put("headerEditUser", "Редактировать профиль");
		 enLanguage.put("headerLogout", "Log Out");
		 frLanguage.put("headerLogout", "Déconnexion");
		rusLanguage.put("headerLogout", "Выход");
		
		//menu page Strings
		 enLanguage.put("menuPoliceNews", "police news");
		 frLanguage.put("menuPoliceNews", "nouvelles de la police");
		rusLanguage.put("menuPoliceNews", "Новости");
		 enLanguage.put("menuHome", "Home");
		 frLanguage.put("menuHome", "Accueil");
		rusLanguage.put("menuHome", "домашняя станица");
		 enLanguage.put("menuMyCases", "My Cases");
		 frLanguage.put("menuMyCases", "Mes Cases");
		rusLanguage.put("menuMyCases", "Мои дела");
		 enLanguage.put("menuMyCityCases", "My City's Cases");
		 frLanguage.put("menuMyCityCases", "Cas De Ma Ville");
		rusLanguage.put("menuMyCityCases", "Городские Дела");
		 enLanguage.put("menuMyProvinceCases", "My Province's Cases");
		 frLanguage.put("menuMyProvinceCases", "Cas De Ma Province");
		rusLanguage.put("menuMyProvinceCases", "Провинциальные дела");
		 enLanguage.put("menuHistory", "History");
		 frLanguage.put("menuHistory", "Histoire");
		rusLanguage.put("menuHistory", "История");
		 enLanguage.put("menuAdvancedSearch", "Advanced Search");
		 frLanguage.put("menuAdvancedSearch", "Recherche Avancée");
		rusLanguage.put("menuAdvancedSearch", "Поиск");
		
		
		//splash screen Strings
		 enLanguage.put("splashScreenTitle", "Hello");
		 frLanguage.put("splashScreenTitle", "Bonjour");
		rusLanguage.put("splashScreenTitle", "Привет");
		 enLanguage.put("splashScreenInfo", "This is non-profit project to make our roads safer");
		 frLanguage.put("splashScreenInfo", "Ce projet est à but non lucratif pour rendre nos routes plus sûres");
		rusLanguage.put("splashScreenInfo", "Это некомрческий проекут цель которого сделать дороги безопаснее");
		 enLanguage.put("splashScreenClose", "Close");
		 frLanguage.put("splashScreenClose", "Fermer");
		rusLanguage.put("splashScreenClose", "Закрыть");
		
		//index page body Strings
		 enLanguage.put("indexWelcome", "Welcome");
		 frLanguage.put("indexWelcome", "Bienvenue");
		rusLanguage.put("indexWelcome", "Добро пожаловать");
		 enLanguage.put("indexComplaint", "Complaint");
		 frLanguage.put("indexComplaint", "Plainte");
		rusLanguage.put("indexComplaint", "Жалоба");
		 enLanguage.put("indexEmail", "email");
		 frLanguage.put("indexEmail", "email");
		rusLanguage.put("indexEmail", "имаил");
		 enLanguage.put("indexOr", "OR");
		 frLanguage.put("indexOr", "OU");
		rusLanguage.put("indexOr", "ИЛИ");
		 enLanguage.put("indexPhone", "Phone Number");
		 frLanguage.put("indexPhone", "Numéro de Téléphone");
		rusLanguage.put("indexPhone", "Телефон");
		 enLanguage.put("indexAnonymous", "Anonymous");
		 frLanguage.put("indexAnonymous", "Anonyme");
		rusLanguage.put("indexAnonymous", "Анонимный");
		 enLanguage.put("indexCreateComplaint", "Create Complaint");
		 frLanguage.put("indexCreateComplaint", "Créer Plainte");
		rusLanguage.put("indexCreateComplaint", "оставить жалобу");
		 enLanguage.put("indexCreateAnonymousComplaint", "Create Anonymous Complaint");
		 frLanguage.put("indexCreateAnonymousComplaint", "Créer Anonyme Plainte");
		rusLanguage.put("indexCreateAnonymousComplaint", "Оставить анонимную жалобу");
		 enLanguage.put("indexEnter", "Enter");
		 frLanguage.put("indexEnter", "Entrer");
		rusLanguage.put("indexEnter", "Вход");
		 enLanguage.put("indexPassword", "Password");
		 frLanguage.put("indexPassword", "Mot de Passe");
		rusLanguage.put("indexPassword", "Пароль");
		 enLanguage.put("indexBadge", "Badge");
		 frLanguage.put("indexBadge", "Badge");
		rusLanguage.put("indexBadge", "Значек");
		 enLanguage.put("indexSignIn", "Sign In");
		 frLanguage.put("indexSignIn", "Connectez-vous");
		rusLanguage.put("indexSignIn", "Вийти");
		 enLanguage.put("indexSignUp", "Sign Up");
		 frLanguage.put("indexSignUp", "Inscrivez-vous");
		rusLanguage.put("indexSignUp", "Регистрация");
		
		//thanks page Strings
		 enLanguage.put("thanksTitle", "Submission Complete");
		 frLanguage.put("thanksTitle", "Présentation Complète");
		rusLanguage.put("thanksTitle", "Отчет отправлен");
		 frLanguage.put("thanksHeader", "Nous vous remercions de votre rapport");
		 enLanguage.put("thanksHeader", "Thank you for your report");
		rusLanguage.put("thanksHeader", "Спасибо за ваш отчет");
		 enLanguage.put("thanksMessage", "We will review your report as soon as possible<br>Your report number is ");
		 frLanguage.put("thanksMessage", "Nous examinerons votre rapport dès que possible <br> Votre numéro de rapport est ");
		rusLanguage.put("thanksMessage", "Мы просмотрим ваш отчет в бижайнее время.<br>Ваш отчет имеет номер ");
		 enLanguage.put("thanksPostMessage", "If you have any questions about your complaint please contact with website support");
		 frLanguage.put("thanksPostMessage", "Si vous avez des questions au sujet de votre plainte s'il vous plaît contactez le support de site Web");
		rusLanguage.put("thanksPostMessage", "Если у нас какие нибуть вопросы о вашем очете пожалуйста свяжитесь с тех.поддержкой");
		
		//signUp page Strings
		rusLanguage.put("signUpTitle", "форма регистрации");
		 frLanguage.put("signUpTitle", "formulaire d'inscription");
		 enLanguage.put("signUpTitle", "registration form");
		rusLanguage.put("signUpBadgeNumber", "Значек");
		 frLanguage.put("signUpBadgeNumber", "Nombre Badge");
		 enLanguage.put("signUpBadgeNumber", "Badge Number");
		rusLanguage.put("signUpAccessCode", "Коде Доступа");
		 frLanguage.put("signUpAccessCode", "Code D'accès");
		 enLanguage.put("signUpAccessCode", "Access Code");
		rusLanguage.put("signUpName", "Ник");
		 frLanguage.put("signUpName", "Nom Pseudo");
		 enLanguage.put("signUpName", "User Name");
		rusLanguage.put("signUpFirstName", "Имя");
		 frLanguage.put("signUpFirstName", "Prénom");
		 enLanguage.put("signUpFirstName", "First Name");
		rusLanguage.put("signUpLastName", "Фамилия");
		 frLanguage.put("signUpLastName", "Nom de Famille");
		 enLanguage.put("signUpLastName", "Last Name");
		rusLanguage.put("signUpEmail", "Имаил адрес");
		 frLanguage.put("signUpEmail", "Adresse Email");
		 enLanguage.put("signUpEmail", "Email Address");
		rusLanguage.put("signUpPhone", "Телефонный номер");
		 frLanguage.put("signUpPhone", "Numéro de téléphone");
		 enLanguage.put("signUpPhone", "Phone Number");
		rusLanguage.put("signUpPassword", "Пароль");
		 frLanguage.put("signUpPassword", "Mot de Passe");
		 enLanguage.put("signUpPassword", "Password");
		rusLanguage.put("signUpConfirmPassword", "Подтверждение Пароля");
		 frLanguage.put("signUpConfirmPassword", "Confirmez Le Mot De Passe");
		 enLanguage.put("signUpConfirmPassword", "Confirm Password");
		rusLanguage.put("signUpButton", "Регистрация");
		 frLanguage.put("signUpButton", "Inscrivez-vous");
		 enLanguage.put("signUpButton", "SignUp");
		 
		 //EDIT
		 enLanguage.put("editOldPassword", "Old Password");
		 rusLanguage.put("editOldPassword", ":D");
		 frLanguage.put("editOldPassword", "Ancien Mot de Passe");
		 enLanguage.put("editNewPassword", "New Password");
		 rusLanguage.put("editNewPassword", ":(");
		 frLanguage.put("editNewPassword", "Nouveau Mot de Passe");
		 rusLanguage.put("editButton", "");
		 frLanguage.put("editButton", "Modifier Profil");
		 enLanguage.put("editButton", "Edit Profile");
		
		//Create report page String
		 enLanguage.put("reportTitle", "Complaint Form");
		 frLanguage.put("reportTitle", "Formulaire de Plainte");
		rusLanguage.put("reportTitle", "отчетная Форма");
		 enLanguage.put("reportPlateNumber", "Plate Number");
		 frLanguage.put("reportPlateNumber", "Nombre de Plaque D'immatriculation");
		rusLanguage.put("reportPlateNumber", "Номер");
		 enLanguage.put("reportURLlink", "URL Link");
		 frLanguage.put("reportURLlink", "Lien URL");
		rusLanguage.put("reportURLlink", "URL ссылка");
		 enLanguage.put("reportStreet", "Street");
		 frLanguage.put("reportStreet", "Rue");
		rusLanguage.put("reportStreet", "Улица");
		 enLanguage.put("reportPostalCode", "Postal Code");
		 frLanguage.put("reportPostalCode", "Code Postal");
		rusLanguage.put("reportPostalCode", "Почтовй индекс");
		 enLanguage.put("reportDescription", "Description");
		 frLanguage.put("reportDescription", "Description");
		rusLanguage.put("reportDescription", "Пояснения");
		 enLanguage.put("reportButton", "Report");
		 frLanguage.put("reportButton", "Rapport");
		rusLanguage.put("reportButton", "Отправить Отчет");
		
		//welocme page Strings
		 enLanguage.put("welcomeTitle", "Police Application");
		 frLanguage.put("welcomeTitle", "Application de Police");
		rusLanguage.put("welcomeTitle", "Полицейское приложение");
		
		//Incident Report Table Strings
		 enLanguage.put("inicdentTablePlate", "Plate Number");
		 frLanguage.put("inicdentTablePlate", "Nombre de Plaque");
		rusLanguage.put("inicdentTablePlate", "");
		 enLanguage.put("inicdentTableProv", "Province");
		 frLanguage.put("inicdentTableProv", "Province");
		rusLanguage.put("inicdentTableProv", "");
		 enLanguage.put("inicdentTableCity", "City");
		 frLanguage.put("inicdentTableCity", "Ville");
		rusLanguage.put("inicdentTableCity", "");
		 enLanguage.put("inicdentTableStatus", "Status");
		 frLanguage.put("inicdentTableStatus", "Condition");
		rusLanguage.put("inicdentTableStatus", "");
		 enLanguage.put("inicdentTableAction", "Action");
		 frLanguage.put("inicdentTableAction", "Action");
		rusLanguage.put("inicdentTableAction", "");
		 enLanguage.put("inicdentTableView", "View");
		 frLanguage.put("inicdentTableView", "Vue");
		rusLanguage.put("inicdentTableView", "");
		
		//Pop Up Window Strings
		 enLanguage.put("PopUpTake", "Take Case");
		 frLanguage.put("PopUpTake", "Prenez Case");
		rusLanguage.put("PopUpTake", "");
		 enLanguage.put("PopUpDecline", "Decline Case");
		 frLanguage.put("PopUpDecline", "Déclin Case");
		rusLanguage.put("PopUpDecline", "");
		 enLanguage.put("PopUpSave", "Save Changes");
		 frLanguage.put("PopUpSave", "Enregistrer");
		rusLanguage.put("PopUpSave", "");
		 enLanguage.put("PopUpCloseCase", "Close Case");
		 frLanguage.put("PopUpCloseCase", "Ferme Case");
		rusLanguage.put("PopUpCloseCase", "");
		 enLanguage.put("PopUpID", "Record ID: ");
		 frLanguage.put("PopUpID", "Enregistrement ID: ");
		rusLanguage.put("PopUpID", "");
		 enLanguage.put("PopUpUserDesc", "User Description");
		 frLanguage.put("PopUpUserDesc", "Description de l'utilisateur");
		rusLanguage.put("PopUpUserDesc", "");
		 enLanguage.put("PopUpOffNotes", "Officer Notes");
		 frLanguage.put("PopUpOffNotes", "Remarques Officer");
		rusLanguage.put("PopUpOffNotes", "");
		 enLanguage.put("PopUpClose", "Close");
		 frLanguage.put("PopUpClose", "Ferme");
		rusLanguage.put("PopUpClose", "");

		
	
		//common Strings
		rusLanguage.put("addCity", "Добавить Город");
		 frLanguage.put("addCity", "Ajouter une ville");
		 enLanguage.put("addCity", "Add City");
		rusLanguage.put("province", "Провинция");
		 frLanguage.put("province", "Province");
		 enLanguage.put("province", "Province");
		rusLanguage.put("city", "Город");
		 frLanguage.put("city", "Ville");
		 enLanguage.put("city", "City");
		rusLanguage.put("backButton", "Назад");
		 frLanguage.put("backButton", "Arrière");
		 enLanguage.put("backButton", "Back");
		rusLanguage.put("lisenceAgreement", "Я прочитал и согласен с согланием.");
		 frLanguage.put("lisenceAgreement", "Je ai lu et accepte les termes de contrat de licence.");
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
