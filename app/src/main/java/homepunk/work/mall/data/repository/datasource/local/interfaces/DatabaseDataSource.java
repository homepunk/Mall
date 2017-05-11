package homepunk.work.mall.data.repository.datasource.local.interfaces;

import java.util.List;

/**
 * Created by Homepunk on 11.05.2017.
 **/

public interface DatabaseDataSource<T> {
    void insert(T t);

    void update(T t);

    void delete(T t);

    List<T> getAll();
}
