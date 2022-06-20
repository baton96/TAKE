package ejb;

import java.util.List;
import javax.ejb.Local;

@Local
public interface NewsItemFacadeLocal {
    public List<NewsItem> getAllNewsItems();
    void create(NewsItem request);

    void edit(NewsItem request);

    void remove(NewsItem request);

    NewsItem find(Object id);

    List<NewsItem> findAll();

    List<NewsItem> findRange(int[] range);

    int count();
}
