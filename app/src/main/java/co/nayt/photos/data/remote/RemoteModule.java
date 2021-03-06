package co.nayt.photos.data.remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The class defines a module providing a PhotosService.
 */
@Module
public class RemoteModule {
    private String url;

    public RemoteModule(String url) {
        this.url = url;
    }

    @Provides
    @Singleton
    PhotosService provideTypicodeService() {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(PhotosService.class);
    }
}
