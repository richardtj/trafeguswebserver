package br.com.chapecosolucoes.trafegusweb.client.components.renderers.controller
{
	import br.com.chapecosolucoes.trafegusweb.client.components.renderers.view.PaginableComponent;
	import br.com.chapecosolucoes.trafegusweb.client.events.PaginableEvent;

	public class PaginableComponentController
	{
		public function PaginableComponentController()
		{
		}
		public var view:PaginableComponent;
		public function next():void
		{
			if(this.view.paginaAtual  < Math.ceil(this.view.totalRecords/this.view.itensPorPagina))
			{
				this.view.paginaAtual+=1;
				var event:PaginableEvent = new PaginableEvent(PaginableEvent.NEXT,(this.view.paginaAtual-1)*this.view.itensPorPagina);
				this.view.dispatchEvent(event);
			}
		}
		public function prev():void
		{
			if(this.view.paginaAtual > 1)
			{
				this.view.paginaAtual-=1;
				var event:PaginableEvent = new PaginableEvent(PaginableEvent.PREV,(this.view.paginaAtual-1)*this.view.itensPorPagina);
				this.view.dispatchEvent(event);
			}
		}
		public function first():void
		{
			this.view.paginaAtual = 1;
			var event:PaginableEvent = new PaginableEvent(PaginableEvent.FIRST,(this.view.paginaAtual-1)*this.view.itensPorPagina);
			this.view.dispatchEvent(event);
		}
		public function last():void
		{
			this.view.paginaAtual = Math.ceil(this.view.totalRecords/this.view.itensPorPagina);
			var event:PaginableEvent = new PaginableEvent(PaginableEvent.LAST,(this.view.paginaAtual-1)*this.view.itensPorPagina);
			this.view.dispatchEvent(event);
		}
	}
}