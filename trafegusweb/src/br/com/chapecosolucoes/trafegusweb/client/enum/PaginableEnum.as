package br.com.chapecosolucoes.trafegusweb.client.enum
{
	public final class PaginableEnum
	{
		public static const NEXT:PaginableEnum = PaginableEnum.create("next");
		public static const PREV:PaginableEnum = PaginableEnum.create("prev");
		public static const LAST:PaginableEnum = PaginableEnum.create("last");
		public static const FIRST:PaginableEnum = PaginableEnum.create("first");
		private var type:String;
		private static function create(enumType:String):PaginableEnum
		{
			var enum:PaginableEnum = new PaginableEnum();
			enum.type = enumType;
			return enum;
		}
		public function toString():String
		{
			return type;
		}
	}
}