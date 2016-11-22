package jums;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class Twitter4j {
	public static void main(String[] args){
		
		//Twitterdeveloperprogramで取得した各値をセットしていく
		String Consumerkey="";
		String Consumersecret="";
		String Accesstoken = "";
		String Accesstokensecret = "";
		

		Twitter twitter = new TwitterFactory().getInstance();//ツイッターオブジェクトの作成
		AccessToken accessToken = new AccessToken(Accesstoken, Accesstokensecret);//ユーザーを定義
		
		twitter.setOAuthConsumer(Consumerkey,Consumersecret);//ツイッターオブジェクトにコンシューマーキーをセット
		twitter.setOAuthAccessToken(accessToken);//ツイッターオブジェクトにアクセストークンをセット
		
        try{
        /*今回はuserオブジェクトに自分のアクセストークンをセットしていると思います。
         *なので、userオブジェクトは自分のアカウントを元に作成され、取得する値も自分のものになります。
         */
        	
		  User user = twitter.verifyCredentials();//Userオブジェクトを作成
		  System.out.println(user.getId());//自分のアカウントのIDの取得（数字のID)
		  System.out.println(user.getName());//自分のアカウントの名前を取得
		  System.out.println(user.getScreenName());//自分のアカウントのUserNameを取得（アルファベットのみの名前）
		  System.out.println(user.getLocation());//自分のアカウントのプロフィールの場所を取得
		  System.out.println(user.getDescription());//自分のアカウントのプロフィールの説明を取得
		  System.out.println(user.getProfileImageURL());//自分のアカウントのプロフィール画像のURLを取得
		  System.out.println(user.getURL());//自分のアカウントのプロフィールのURLを取得する
		  System.out.println(user.isProtected());//自分のアカウントに鍵がついてるか取得する
		  System.out.println(user.getStatusesCount()); //呟きの数を取得

		} catch (TwitterException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}//Userオブジェクトを作成
		
		
		
		
		
	}
	

}
