package br.com.chapecosolucoes.trafegusweb.client.model
{
	public class UsuarioLogado
	{
		private static var instance:UsuarioLogado;
		
		public function UsuarioLogado(enforcer:SingletonEnforcer)
		{
			public var codigo:int;
			public var empresa:int;
			
			if (enforcer == null)
			{
				throw new Error("Só pode haver uma instância de [UsuarioLogado]");
			}
			
			public static function getInstance():UsuarioLogado
			{
				if (instance == null)
					instance = new MainModel(new SingletonEnforcer());
				return instance;
			}
		}
	}
}
class SingletonEnforcer
{
	
}