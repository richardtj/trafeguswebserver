package br.com.chapecosolucoes.trafegusweb.client.enum
{
	public final class SMEnum
	{
		public static const NOVA:SMEnum = SMEnum.create("nova");
		public static const EDITAR:SMEnum = SMEnum.create("editar");
		private var type:String;
		
		private static function create(enumType:String):SMEnum
		{
			var enum:SMEnum = new SMEnum();
			enum.type = enumType;
			return enum;
		}
	}
}