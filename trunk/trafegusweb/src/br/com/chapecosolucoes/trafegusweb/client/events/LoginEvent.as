package br.com.chapecosolucoes.trafegusweb.client.events
{
    import flash.events.Event;

    public class LoginEvent extends Event
    {
        public var logged:Boolean = false;

        public static const LOGIN_EVENT:String = "loginEvent";

        public function LoginEvent(type:String, logged:Boolean)
        {
            this.logged = logged;
            super(type);
        }

        override public function clone():Event
        {
            return new LoginEvent(this.type, this.logged);
        }
    }
}