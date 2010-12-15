package br.com.chapecosolucoes.trafegusweb.client.enum
{
	public final class SimNaoEnum
	{
		public static const SIM:SimNaoEnum = SimNaoEnum.create("S");
		public static const NAO:SimNaoEnum = SimNaoEnum.create("N");
		private var type:String;
		private static function create(enumType:String):SimNaoEnum
		{
			var enum:SimNaoEnum = new SimNaoEnum();
			enum.type = enumType;
			return enum;
		}
		public function toString():String
		{
			if(this.type == "S")
			{
				return "Sim";
			}
			else
			{
				return "Não";
			}
		}
	}
}