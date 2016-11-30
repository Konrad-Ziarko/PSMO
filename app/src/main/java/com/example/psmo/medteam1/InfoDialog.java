package com.example.psmo.medteam1;

import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class InfoDialog extends Dialog implements OnClickListener
{

    private Button okButton;
    private Context mContext;
    private TextView mTitle = null;
    private TextView mMessage = null;
    private View v = null;

    public InfoDialog(Context context)
        {
            super(context);
            mContext = context;
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            setContentView(R.layout.infodialog);
            v = getWindow().getDecorView();
            v.setBackgroundResource(android.R.color.transparent);
            mTitle = (TextView) findViewById(R.id.dialogTitle);
            mMessage = (TextView) findViewById(R.id.dialogMessage);
            okButton = (Button) findViewById(R.id.OkButton);
            okButton.setOnClickListener(this);
        }
    @Override
    public void onClick(View v)
        {
            if (v == okButton)
                dismiss();
        }
    @Override
    public void setTitle(CharSequence title)
        {
            super.setTitle(title);
            mTitle.setText(title);
        }
    @Override
    public void setTitle(int titleId)
        {
            super.setTitle(titleId);
            mTitle.setText(mContext.getResources().getString(titleId));
        }

    public void setMessage(CharSequence message)
        {
            mMessage.setText(message);
            mMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        }

    public void setMessage(int messageId)
        {
            mMessage.setText(mContext.getResources().getString(messageId));
            mMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
}