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
			var event:PaginableEvent = new PaginableEvent(PaginableEvent.NEXT);
			this.view.dispatchEvent(event);
		}
		public function prev():void
		{
			var event:PaginableEvent = new PaginableEvent(PaginableEvent.PREV);
			this.view.dispatchEvent(event);
		}
		public function first():void
		{
			var event:PaginableEvent = new PaginableEvent(PaginableEvent.FIRST);
			this.view.dispatchEvent(event);
		}
		public function last():void
		{
			var event:PaginableEvent = new PaginableEvent(PaginableEvent.LAST);
			this.view.dispatchEvent(event);
		}
	}
}