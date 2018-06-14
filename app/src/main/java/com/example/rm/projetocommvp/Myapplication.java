package com.example.rm.projetocommvp;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.InspectorModulesProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder;

import okhttp3.OkHttpClient;

public class Myapplication extends Application {

    public OkHttpClient httpClient;

    @Override
    public void onCreate() {
        super.onCreate();

        final Context context = this;


            // Create an InitializerBuilder
            Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

            // Enable Chrome DevTools with JavaScript Console Support
            initializerBuilder.enableWebKitInspector(new InspectorModulesProvider() {
                @Override
                public Iterable<ChromeDevtoolsDomain> get() {
                    return new Stetho.DefaultInspectorModulesBuilder(context).runtimeRepl(
                            new JsRuntimeReplFactoryBuilder(context)
                                    // Pass to JavaScript: var foo = "bar";
                                    .addVariable("foo", "bar")
                                    .build()
                    ).finish();
                }
            });

            // Use the InitializerBuilder to generate an Initializer
            Stetho.Initializer initializer = initializerBuilder.build();

            // Initialize Stetho with the Initializer
            Stetho.initialize(initializer);

            //Initialize Stetho Interceptor into OkHttp client
            httpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();


    }
}