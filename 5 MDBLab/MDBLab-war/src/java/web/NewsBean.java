package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

@Named(value = "newsBean")
@RequestScoped
public class NewsBean {
    private String headingText;
    private String bodyText;

    @Inject
    private NewsItemFacadeLocal facade;

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:app/jms/NewsQueue")
    private javax.jms.Queue queue;

    public NewsBean() {
    }

    void sendNewsItem(String heading, String body) {
        String msg = String.format("%s|%s", heading, body);
        TextMessage message = context.createTextMessage(msg);
        context.createProducer().send(queue, message);
    }

    public List<NewsItem> getNewsItems() {
        return facade.getAllNewsItems();
    }

    /**
     * @return the headingText
     */
    public String getHeadingText() {
        return headingText;
    }

    /**
     * @param headingText the headingText to set
     */
    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    /**
     * @return the bodyText
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * @param bodyText the bodyText to set
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }
    
    public String submitNews() {
        NewsItem newsItem = new NewsItem(headingText, bodyText);
        facade.create(newsItem);
        setHeadingText("");
        setBodyText("");
        return null;
    }
}
