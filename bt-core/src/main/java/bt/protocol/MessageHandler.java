package bt.protocol;

public interface MessageHandler<T extends Message> {

    /**
     * Tries to decode message from the byte buffer. If decoding is successful, then the result is set
     * into the message {@code context}
     *
     * @param context Message context. In case of success the decoded message must be put into this context.
     * @param data Byte buffer of arbitrary length containing (a part of) the message
     * @return Number of bytes consumed (0 if the provided data is insufficient)
     * @throws InvalidMessageException if data is invalid
     */
    int fromByteArray(MessageContext context, byte[] data);

    /**
     * @return Encoded message
     * @throws InvalidMessageException if message type is not supported or encoding is not possible
     */
    byte[] toByteArray(T message);
}
