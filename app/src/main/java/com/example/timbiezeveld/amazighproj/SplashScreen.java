package com.example.timbiezeveld.amazighproj;



    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;

    /**
     * Created by vamsikrishna on 12-Feb-15.
     */
    public class SplashScreen extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            // TODO Auto-generated method stub
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash);

            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        sleep(4000);

                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                        startActivity(intent);//comment
                    }
                }
            };
            timerThread.start();
        }

        @Override
        protected void onPause() {
            // TODO Auto-generated method stub
            super.onPause();
            finish();
        }

    }

