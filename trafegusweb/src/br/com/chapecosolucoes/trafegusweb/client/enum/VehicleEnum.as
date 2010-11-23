package br.com.chapecosolucoes.trafegusweb.client.enum
{
	public final class VehicleEnum
	{
		public static const LIST:VehicleEnum = VehicleEnum.create("list");
		public static const DETAILS:VehicleEnum = VehicleEnum.create("details");
		private var type:String;
		/*public function VehicleEnum(singletonEnforcer:SingletonForcer)
		{
			if(singletonEnforcer==null)
			{
				throw new Error("Não é possivel instanciar um enum");
			}
		}*/
		private static function create(enumType:String):VehicleEnum
		{
			var enum:VehicleEnum = new VehicleEnum();
			enum.type = enumType;
			return enum;
		}
	}
}

class SingletonForcer
{
	
}