package testData.data;

public enum Language {
    EN("Learn languages for free!"),
    FR("Apprends des langues gratuitement !"),
    IT("Impara le lingue gratuitamente!");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}
