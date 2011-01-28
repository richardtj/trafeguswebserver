package br.com.chapecosolucoes.trafegusweb.client.enum
{

    public final class LocaisEnum
    {
        public static const ORIGEM:LocaisEnum = LocaisEnum.create("4");

        public static const DESTINO:LocaisEnum = LocaisEnum.create("5");

        public static const PARADA:LocaisEnum = LocaisEnum.create("1");

        private var type:String;
		
        private static function create(enumType:String):LocaisEnum
        {
            var enum:LocaisEnum = new LocaisEnum();
            enum.type = enumType;
            return enum;
        }
		public function toString():String
		{
			return this.type;
		}
    }
}