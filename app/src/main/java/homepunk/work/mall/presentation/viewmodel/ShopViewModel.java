package homepunk.work.mall.presentation.viewmodel;

/**
 * Created by Homepunk on 05.05.2017.
 **/

public class ShopViewModel {
    private int id;
    private String name;
    private String description;
    private String level;
    private String color;
    private String iamgeUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIamgeUrl() {
        return iamgeUrl;
    }

    public void setIamgeUrl(String iamgeUrl) {
        this.iamgeUrl = iamgeUrl;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(id)
                .append(" ")
                .append(name)
                .append(" ")
                .append(level)
                .toString();
    }
}
