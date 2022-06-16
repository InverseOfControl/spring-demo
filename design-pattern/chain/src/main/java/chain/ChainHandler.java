package chain;

public abstract class ChainHandler {

    private ChainHandler next;

    public void setNext(ChainHandler next) {
        this.next = next;
    }

    public ChainHandler getNext() {
        return next;
    }

    public void nextDoHandle(String msg) {
        if (null != getNext()) {
            getNext().doHandle(msg);
        }
    }

    public abstract void doHandle(String msg);


    static class Builder {
        private ChainHandler head;
        private ChainHandler tail;

        Builder add(ChainHandler handler) {
            if (null == this.head) {
                this.head = this.tail = handler;
                return this;
            }

            this.tail.next = handler;
            this.tail = handler;

            return this;
        }

        ChainHandler build() {
            return this.head;
        }
    }
}


