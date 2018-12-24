package com.jm.android.gt.floatview.renderer;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jm.android.gt.JMGTRAnalysisResult;
import com.jm.android.gt.R;
import com.jm.android.gt.floatview.JMFloatViewType;
import com.jm.android.gt.manager.JMGTRAnalysisManager;
import com.jm.android.gt.utils.DecimalFormatUtil;

public class JMGetCPUInfoRenderer extends BaseRenderer {

    @Override
    public String type() {
        return JMFloatViewType.TYPE_FLOAT_VIEW_CPU_VIEW;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.jm_gt_item_floatview_keyvalue;
    }

    @Override
    protected void renderer(View mView) {
        TextView keyView = mView.findViewById(R.id.tv_key);
        TextView valueView = mView.findViewById(R.id.tv_value);
        keyView.setText(R.string.jm_gt_floatview_cpu);
        JMGTRAnalysisResult analysisResult = JMGTRAnalysisManager.getInstance().getJMGTRAnalysisResult();
        String data = DecimalFormatUtil.setScale(analysisResult.cmntInfo.cpu, 1) + "%";
        if (!TextUtils.isEmpty(data)) {
            valueView.setText(data);
        }
    }
}