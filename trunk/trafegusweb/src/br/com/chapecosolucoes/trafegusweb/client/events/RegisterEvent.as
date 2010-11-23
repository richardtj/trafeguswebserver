package br.com.chapecosolucoes.trafegusweb.client.events
{
	import flash.events.Event;

	public class RegisterEvent extends Event
	{
		public var userName:String;
		public var passWord:String;
		public const static REGISTER_EVENT:String = "registerEvent";
		public function RegisterEvent(type:String,userName:String,passWord:String)
		{
			super(type);
		}
		override public function clone():Event
		{
			return new RegisterEvent(this.type,this.userName,this.passWord);
		}
		
	}
}