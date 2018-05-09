package android.madar.io.madarsoft.ui.newLocations;

import android.madar.io.madarsoft.ui.base.MvpView;

public interface MapMvpView extends MvpView {

    void setViews();

    void showProgress();

    void hideProgress();

    void saveData(String lng, String lat);

    void SuccessfulSave();

    void incrementPlace();
}
