package by.bsuir.entity.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "message_status_ref")
public class MessageStatus {

    @Id
    @Column(name = "message_status_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private Integer messageStatusId;

    @Column(name = "message_status_name")
    @ToString.Include
    @EqualsAndHashCode.Include
    @NotNull
    private String messageStatusName;
}
