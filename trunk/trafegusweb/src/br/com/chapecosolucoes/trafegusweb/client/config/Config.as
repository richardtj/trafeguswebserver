package br.com.chapecosolucoes.trafegusweb.client.config
{
	import mx.collections.ArrayCollection;

	public class Config
	{
		[Bindable]
		public var wsdl:String;
		
		private static var instance:Config;

		public function Config(enforcer:Enforcer)
		{

		}

		public static function getInstance():Config
		{
			if (instance == null)
			{
				instance = new Config(new Enforcer())
			}
			return instance;
		}
	}
}

class Enforcer
{
}