package br.com.chapecosolucoes.trafegusweb.client.model
{
	[Bindable]
	public class UsuarioLogado
	{
		private static var instance:UsuarioLogado;
		public var wsdl:String;
		
		//--- Variaveis de posicionamento do Grid de veiculos
		public var gridVeiculosX:int = 0;
		public var gridVeiculosY:int = 20;
		public var gridVeiculosPercentWidth:int = 20;
		public var gridVeiculosPercentHeight:int = 100;
		
		//--- Variaveis de posicionamento do Google Maps
		public var mapaGoogleX:int = 272;
		public var mapaGoogleY:int = 20;
		public var mapaGooglePercentWidth:int = 80;
		public var mapaGooglePercentHeight:int = 50;
		
		//--- Variaveis de posicionamento do Grid de detalhe
		public var gridDetalheX:int = 272;
		public var gridDetalheY:int = 274;
		public var gridDetalhePercentWidth:int = 80;
		public var gridDetalhePercentHeight:int = 50;

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