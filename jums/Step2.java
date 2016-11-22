package jums;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;

public class Step2 {
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

		//Step2はここから
		try {
			/*前回インポートしているもの+でインストールしているものがあります。それを忘れずに。
			 *今回は自分のタイムラインを取得してみましょう
			 */
			User user = twitter.verifyCredentials();// Userオブジェクトを作成
			
			/*
			 * getUserTimeline()の引数にTweetを取得したいuserの@nameを入力すれば取得できます
			 * 未入力の場合、アクセストークンにセットされているuserのTweetを取得します。
			 * また、セットされているアクセストークンがみれないuserのTweetは取得できません。（例）鍵垢で、認証をもらってない人。
			 */
			 ResponseList<Status> list_status = twitter.getUserTimeline("");
			  for (Status status : list_status) {
			      System.out.println("ツイート：" + status.getText());
			  }

			
		} catch (TwitterException e) {// エラーのキャッチを行う

			System.out.println("エラーが発生しました:" + e);
			e.printStackTrace();
		}
	}
}
