package br.com.chapecosolucoes.trafegusweb.client.enum
{
	public final class LimparDistanciasEnum
	{
		public static const TODAS:LimparDistanciasEnum = LimparDistanciasEnum.create("todas");
		public static const ULTIMA:LimparDistanciasEnum = LimparDistanciasEnum.create("ultima");
		public static const NENHUMA:LimparDistanciasEnum = LimparDistanciasEnum.create("nenhuma");
		private var type:String;
		private static function create(enumType:String):LimparDistanciasEnum
		{
			var enum:LimparDistanciasEnum = new LimparDistanciasEnum();
			enum.type = enumType;
			return enum;
		}
		public function toString():String
		{
			return this.type;
		}
	}
}