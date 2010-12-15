package br.com.chapecosolucoes.trafegusweb.client.enum
{
	public final class SexoEnum
	{
		public static const MASCULINO:SexoEnum = SexoEnum.create("M");
		public static const FEMININO:SexoEnum = SexoEnum.create("F");
		private var type:String;
		private static function create(enumType:String):SexoEnum
		{
			var enum:SexoEnum = new SexoEnum();
			enum.type = enumType;
			return enum;
		}
		public function toString():String
		{
			if(this.type == "M")
			{
				return "Masculino";
			}
			else
			{
				return "Feminino";
			}
		}
	}
}