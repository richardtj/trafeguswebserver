package br.com.chapecosolucoes.trafegusweb.client.model
{
	[Bindable]
	public class UsuarioLogado
	{
		private static var instance:UsuarioLogado;
		public var wsdl:String;
		
		//--- Variaveis de posicionamento do Grid de veiculos
		public var gridVeiculosX:int = 0;
		public var gridVeiculosY:int = 0;
		public var gridVeiculosWidth:int = 0;
		public var gridVeiculosHeight:int = 0;
		
		//--- Variaveis de posicionamento do Google Maps
		public var mapaGoogleX:int = 0;
		public var mapaGoogleY:int = 0;
		public var mapaGoogleWidth:int = 0;
		public var mapaGoogleHeight:int = 0;
		
		//--- Variaveis de posicionamento do Grid de detalhe
		public var gridDetalheX:int = 0;
		public var gridDetalheY:int = 0;
		public var gridDetalheWidth:int = 0;
		public var gridDetalheHeight:int = 0;

		public function UsuarioLogado(enforcer:SingletonEnforcer)
		{
			if (enforcer == null)
			{
				throw new Error("Só pode haver uma instância de [UsuarioLogado]");
			}
			
		}
		public static function getInstance():UsuarioLogado
		{
			if (instance == null)
				instance = new UsuarioLogado(new SingletonEnforcer());
			return instance;
		}

	}
}
class SingletonEnforcer
{
	
}