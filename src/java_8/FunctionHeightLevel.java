package java_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionHeightLevel {

    /**
     * Class @Class Printer contained mush verbose works with Java 8
     * @param args
     */
    public static void main(String[] args) {
        ArticleWork articleWork = new ArticleWork("Java1");

        System.out.println(articleWork.layers());

        System.out.println(articleWork.layersNew());
    }

}

class ArticleWork {

    private List<Article> articles;
    private String neededElement;

    public ArticleWork(String needElemFoFilter) {
        articles = new ArrayList<Article>() {{
            add(new Article("Tag_1"));
            add(new Article("Java1"));
            add(new Article("lalal"));
        }};
        this.neededElement = needElemFoFilter;
    }

    public List<Article> getAllArticles() {
        return articles;
    }

    public Article fetchLatestArticle() {
        return articles.get(articles.size() - 1);
    }

    public Optional<Article> getFirstJavaArticle() {
        return articles.stream()
                .filter(article -> article.getTags().contains(this.neededElement))
                .findFirst();
    }

    public String layers() {
        return (this.getFirstJavaArticle().orElseGet(this::fetchLatestArticle)).getTags();
    }

    // Тип круто
    public Optional<Article> getFirst(Predicate<Article> predicate) {

        return articles.stream()
                .filter(predicate)
                .findFirst();
    }

    public String layersNew() {
        return (this.LayerBeetwenLayerNew().orElseGet(this::fetchLatestArticle)).getTags();
    }

    public Optional<Article> LayerBeetwenLayerNew() {
        Function<String, Predicate<Article>> basedOnTag = tag -> article -> article.getTags().contains(tag);
        return getFirst(basedOnTag.apply("Java123"));
    }

}

class Article {

    public Article(String tags) {
        setTags(tags);
    }

    private String tags;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

}