package jp.chau2chaun2.kotlindatabindingsample.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jp.chau2chaun2.kotlindatabindingsample.model.orma.OrmaDatabase;

@Module
public class AppModule {

    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    LayoutInflater provideLayoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

    @Singleton
    @Provides
    SharedPreferences.Editor provideSharedPreference(Context context) {
        return context.getSharedPreferences("Default", Context.MODE_PRIVATE).edit();
    }
}
