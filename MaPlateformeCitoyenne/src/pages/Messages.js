import './Messages.css';
import React, { useState } from 'react';
import { IoIosSend } from 'react-icons/io';

const Message = ({ text, avatar, isUser }) => {
  const messageClass = `message ${isUser ? "user" : ""}`;
  return (
    <div className={messageClass}>
      {!isUser && <img src={avatar} alt="avatar" className="avatar" />}
      <div className="message-text">{text}</div>
      {isUser && <img src={avatar} alt="avatar" className="avatar" />}
    </div>
  );
};


const Messages = () => {
  const [messages, setMessages] = useState([
    { id: 1, text: "J'aimerais savoir l'état d'avancement par rapport à ma demande d'hier", avatar: 'path/to/avatar1.png', isUser: true },
    { id: 2, text: "Votre demande est toujours en cours de traitement on vous informera par rapport à son évolution", avatar: 'path/to/avatar2.png', isUser: false },
 
  ]);
  const [newMessage, setNewMessage] = useState('');

  const handleSend = () => {
    if (newMessage.trim()) {
      const nextId = Math.max(...messages.map((m) => m.id)) + 1;
      const message = {
        id: nextId,
        text: newMessage,
        avatar: 'path/to/your-avatar.png',
        isUser: true,
      };
      setMessages([...messages, message]);
      setNewMessage('');
    }
  };

  return (
    <div className="messenger">
      <div className="messenger-header">
        <p>Logo</p>
        <p>Username</p>
      </div>
      <div className="message-list">
        {messages.map((message) => (
          <Message
            key={message.id}
            text={message.text}
            avatar={message.avatar}
            isUser={message.isUser}
          />
        ))}
      </div>
      <div className="message-box">
        <input
          type="text"
          value={newMessage}
          onChange={(e) => setNewMessage(e.target.value)}
          placeholder="Écrire un message"
          className="message-input"
        />
        <button onClick={handleSend} className="send-button">
          <IoIosSend />
          Envoyer
        </button>
      </div>
    </div>
  );
};

export default Messages;
