package com.vertex.commanddesignpatten.command;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
}
