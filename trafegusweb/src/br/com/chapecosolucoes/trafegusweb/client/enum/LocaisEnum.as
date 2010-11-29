package br.com.chapecosolucoes.trafegusweb.client.enum
{
	public final class LocaisEnum
	{
		public static const ORIGEM:LocaisEnum = LocaisEnum.create("origem");
		public static const DESTINO:LocaisEnum = LocaisEnum.create("destino");
		private var type:String;
		private static function create(enumType:String):LocaisEnum
		{
			var enum:LocaisEnum = new LocaisEnum();
			enum.type = enumType;
			return enum;
		}
	}
}