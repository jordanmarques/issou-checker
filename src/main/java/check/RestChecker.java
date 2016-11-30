package check;

import mail.Mail;
import okhttp3.OkHttpClient;
import okhttp3.Response;

import javax.mail.MessagingException;

public class RestChecker {

    private String url;
    private Response response;

    public RestChecker(String url) {
        this.url = url;

        OkHttpClient client = new OkHttpClient();

        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .build();

        try{
            this.response  = client.newCall(request).execute();
        } catch(Exception e){}
    }

    public int getCode(){
        return response.code();
    }

    public Boolean isResponded(){
        return response.code() == 200;
    }

    public void sendMailIfNotResponded(String recipients, String appName){
        if( ! isResponded() ){
            try {
                Mail mail = new Mail();
                mail.send(recipients,appName , appName + " is not responded to health check");
                System.out.println(appName + " is not responded to health check");
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
