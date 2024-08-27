package com.mai.physical.events;

import com.mai.physical.model.PairBindingDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

@Getter
@Setter
public class PairBindingEvent extends ApplicationEvent {
    public List<PairBindingDto> getBindings() {
        return bindings;
    }

    private List<PairBindingDto> bindings;

    public PairBindingEvent(Object source, List<PairBindingDto> bindings) {
        super(source);
        this.setBindings(bindings);
    }

}
