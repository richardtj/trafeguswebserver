package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;

	public class LoginEvent extends Event
	{
		public var userName:String;
		public var passWord:String;
		public static const LOGIN_EVENT:String = "loginEvent";
		public function LoginEvent(type:String,userName:String,passWord:String)
		{
			this.userName = userName;
			this.passWord = passWord;
			super(type);
		}
		override public function clone():Event
		{
			return new LoginEvent(this.type,this.userName,this.passWord);
		}
	}
}