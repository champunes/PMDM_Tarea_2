package com.iesaguadulce.pmdmtarea2;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.pm.PackageInfoCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iesaguadulce.pmdmtarea2.databinding.FragmentAboutBinding;

public class AboutFragment extends Fragment {

    private FragmentAboutBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentAboutBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvVersionText.setText(getAppVersion());

        binding.chSocial.setOnClickListener(v -> {
            Intent urlIntent =
                    new Intent(Intent.ACTION_VIEW, Uri.parse(getText(R.string.fragment_about_social_url).toString()));
            startActivity(urlIntent);
        });
    }

    private String getAppVersion() {
        try {
            PackageInfo packageInfo;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(),
                        PackageManager.PackageInfoFlags.of(0));
            } else {
                packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            }

            return packageInfo.versionName + " (" + PackageInfoCompat.getLongVersionCode(packageInfo) + ")";

        } catch (Exception e) {
            return getText(R.string.fragment_about_version_text).toString();
        }
    }
}
