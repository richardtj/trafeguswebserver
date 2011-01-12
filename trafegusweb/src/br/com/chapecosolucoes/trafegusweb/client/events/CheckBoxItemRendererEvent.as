package br.com.chapecosolucoes.trafegusweb.client.events
{
    import flash.events.Event;

    import mx.controls.DataGrid;

    public class CheckBoxItemRendererEvent extends Event
    {
        public static const VISIBLE_CHANGED:String = "visibleChanged";

        public var visible:Boolean;

        public var coluna:String;

        public var grid:DataGrid;

        public function CheckBoxItemRendererEvent(type:String, coluna:String, visible:Boolean, bubbles:Boolean = false, cancelable:Boolean = false)
        {
            this.visible = visible;
            this.coluna = coluna;
            super(type, bubbles, cancelable);
        }

        override public function clone():Event
        {
            return new CheckBoxItemRendererEvent(type, coluna, visible, bubbles, cancelable);
        }
    }
}