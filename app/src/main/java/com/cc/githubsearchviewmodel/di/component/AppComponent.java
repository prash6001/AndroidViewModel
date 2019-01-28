package com.cc.githubsearchviewmodel.di.component;

import android.app.Application;

import com.cc.githubsearchviewmodel.applicationpack.GitHubSearchApplication;
import com.cc.githubsearchviewmodel.di.modules.ActivityModule;
import com.cc.githubsearchviewmodel.di.modules.AndroidMVVMDatabaseModule;
import com.cc.githubsearchviewmodel.di.modules.AndroidMVVMSharedPrefModule;
import com.cc.githubsearchviewmodel.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules={AndroidSupportInjectionModule.class,ActivityModule.class, AppModule.class, AndroidMVVMSharedPrefModule.class,
        AndroidMVVMDatabaseModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }

    void inject(GitHubSearchApplication app);
}
