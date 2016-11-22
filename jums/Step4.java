package jums;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class Step4 {
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

		//Step4はここから
		try {
			/*
			 * 今回はオバマをフォローして、ツイートをお気に入り、RTし、オバマにおつかれさまでしたとDMを送りましょう
			 */
			
			twitter.createFriendship("@BarackObama");//指定したユーザーをフォローする
			//twitter.destroyFriendship("@BarackObama");これでリブーブすることができます
			
			
			Long id=794926969829920768l;//サンプルとしてオバマの11月5日のツイートのID.
			/*
			 * idの取得方法はstep2を参照
			 */
			
			
			twitter.createFavorite(id);//お気に入りをする
			//twitter.destroyFavorite(123455);;これでお気に入りを解除する
			
			twitter.retweetStatus(id);//RTをする
			
			/* RTを削除するメソッドはない。今回の例でいうと、オバマのツイートを削除。ということができてはいけないからだ。
			 * RTをとり消すには、 自分がRTしたタイミングで生成されるIDを調べて,
			 * twitter.destroyStatus(id);
			 * で削除する
			 */
		
			
			
			/*--------------------------------------------------------------------------------------------
			 * twitter.sendDirectMessage("@BarackObama","おつかれさまでした");
			 * DMを送る。("送信先","内容")
			 * Twitterの仕様変更でDMを受け付けない設定が可能となりました。オバマはDMを受け取らない設定のため送ることができない
			--------------------------------------------------------------------------------------------- */
			
			
			
			
			
			
			
			
		} catch (TwitterException e) {// エラーのキャッチを行う

			System.out.println("エラーが発生しました:" + e);
			e.printStackTrace();
		}

	}

}
