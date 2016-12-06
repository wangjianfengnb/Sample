package com.sample.retrofit;


import java.util.ArrayList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jam on 16-5-17
 * Description:
 */
public interface ApiService {

    @GET("api/data/福利/{pageCount}/{pageIndex}")
    Observable<BaseModel<ArrayList<Benefit>>> rxBenefits(
            @Path("pageCount") int pageCount,
            @Path("pageIndex") int pageIndex

    );
}





