package jums;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class Step3 {
	public static void main(String[] args) {
		//Step1を読んでね
		String Consumerkey = "";
		String Consumersecret = "";
		String Accesstoken = "";
		String Accesstokensecret = "";
		Twitter twitter = new TwitterFactory().getInstance();;
		AccessToken accessToken = new AccessToken(Accesstoken, Accesstokensecret);
		twitter.setOAuthConsumer(Consumerkey, Consumersecret);
		twitter.setOAuthAccessToken(accessToken);

		//Step3はここから
		try {
			/*
			 * 今回はつぶやいてみましょう。
			 * 注意点としては、同じ内容を連続ではつぶやけません。
			 */
			
			String msg="TwitterAPIテスト";//　つぶやく内容を変数に代入
			
			twitter.updateStatus(msg);//updatestatusでつぶやく
			
		} catch (TwitterException e) {// エラーのキャッチを行う

			System.out.println("エラーが発生しました:" + e);
			e.printStackTrace();
		}
	}
}